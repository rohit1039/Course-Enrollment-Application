import { useEffect, useState } from 'react';
import User from '../../models/user';
import { useDispatch, useSelector } from 'react-redux';
import { Link, useNavigate } from 'react-router-dom';
import AuthenticationService from '../../services/authentication.service';
import { setCurrentUser } from '../../store/actions/user';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSignInAlt } from '@fortawesome/free-solid-svg-icons';
import { faTimesCircle} from '@fortawesome/free-solid-svg-icons';
import '../register/RegisterPage.css';
import { Alert } from 'react-bootstrap';
import { toast} from 'react-toastify'


const LoginPage = () => {

    const [user, setUser] = useState(new User('', '', ''));
    const [loading, setLoading] = useState(false);
    const [submitted, setSubmitted] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');

    const currentUser = useSelector(state => state.user);

    const navigate = useNavigate();

    const dispatch = useDispatch();

    //mounted
    useEffect(() => {
        if (currentUser?.id) {
            navigate('/profile');
        }
    }, [currentUser?.id,navigate]);

    //<input onChange=(event => handleChange(event))>
    const handleChange = (e) => {
        const {name, value} = e.target;

        setUser((prevState => {
            //E.g: prevState ({user: abc, pass: abc}) + newKeyValue ({user: abcd}) => ({user: abcd, pass: abc})
            return {
                ...prevState,
                [name]: value
            };
        }));
    };

    const handleLogin = (e) => {
      e.preventDefault();

      setSubmitted(true);

      if (!user.username || !user.password) {
          return;
      }

      setLoading(true);

        AuthenticationService.login(user).then(response => {
            toast.success(<i>Login success</i>, {
                position:"bottom-left"
            });
          //set user in session.
          dispatch(setCurrentUser(response.data));
          navigate('/profile');
      }).catch(error => {
          console.log(error);
          setErrorMessage('username or password is not valid.');
          setLoading(false);
      })
    };

    return (
        <div className="container mt-3">
            <div className="card ms-auto me-auto shadow-lg p-2 custom-card">

                <p className="text-center h1 fw-bold mb-3 mx-1 mx-md-4 mt-4">Sign In</p>
                <FontAwesomeIcon icon={ faSignInAlt} className="ms-auto me-auto user-icon p-3"/>

                <div>
                    {errorMessage ?
                        <Alert className="alert alert-danger text-center"> <FontAwesomeIcon icon={faTimesCircle} /> {errorMessage}
                        </Alert> : null}
                </div>

                <form
                    onSubmit={(e) => handleLogin(e)}
                    noValidate
                    className={submitted ? 'was-validated' : ''}
                >
                    <div className="form-group p-2">
                        <label htmlFor="username">Username: </label>
                        <input
                            type="text"
                            className="form-control"
                            name="username"
                            placeholder="username"
                            value={user.username}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Username is required.
                        </div>
                    </div>

                    <div className="form-group p-2">
                        <label htmlFor="password">Password: </label>
                        <input
                            type="password"
                            className="form-control"
                            name="password"
                            placeholder="password"
                            value={user.password}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Password is required.
                        </div>
                    </div>

                    <button
                        className="btn btn-info w-100 mt-3"
                        disabled={loading}>
                        Login
                    </button>

                </form>

                <Link to="/register" className="btn btn-link" style={{color: 'grey'}}>
                    Create New Account!
                </Link>

            </div>
        </div>
    );
};

export {LoginPage};
