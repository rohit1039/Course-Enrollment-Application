import { useEffect, useState } from 'react';
import User from '../../models/user';
import { useSelector } from 'react-redux';
import { Link, useNavigate } from 'react-router-dom';
import AuthenticationService from '../../services/authentication.service';
import './RegisterPage.css';
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome';
import { faUserCircle } from '@fortawesome/free-solid-svg-icons';
import { faExclamationTriangle } from '@fortawesome/free-solid-svg-icons';
import { Alert } from 'react-bootstrap';

const RegisterPage = () => {

    const [user, setUser] = useState(new User('', '', ''));
    const [loading, setLoading] = useState(false);
    const [submitted, setSubmitted] = useState(false);
    const [errorMessage, setErrorMessage] = useState('');

    const currentUser = useSelector(state => state.user);

    const navigate = useNavigate();

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
    }

    const handleRegister = (e) => {

     e.preventDefault();

      setSubmitted(true);

      //validation
      if (!user.username || !user.password || !user.fullname) {
          return;
      }

      setLoading(true);

      AuthenticationService.register(user).then(_ => {
          navigate('/login');
      }).catch(error => {
          console.log(error);
          if (error?.response?.status === 409) {
              setErrorMessage('username or password is not valid.');
          } else {
              setErrorMessage('Unexpected error occurred!');
          }
          setLoading(false);
      });
    }; 

    return (
        <div className="container mt-3">
            <div className="card ms-auto me-auto p-2 shadow-lg custom-card">

                <p className="text-center h1 fw-bold mb-3 mx-1 mx-md-4 mt-4">Sign up</p>
                <FontAwesomeIcon icon={ faUserCircle} className="ms-auto me-auto user-icon p-3"/>
                <div>
                    {errorMessage ?
                        <Alert className="alert alert-danger text-center"> <FontAwesomeIcon icon={faExclamationTriangle} /> {errorMessage}
                        </Alert> : null}
                </div>


                <form
                    onSubmit={(e) => handleRegister(e)}
                    noValidate
                    className={submitted ? 'was-validated' : ''}
                >
                    <div className="form-group p-2">
                        <label htmlFor="fullname">Fullname: </label>
                        <input
                            type="text"
                            className="form-control"
                            name="fullname"
                            placeholder="fullname"
                            value={user.fullname}
                            onChange={(e) => handleChange(e)}
                            required
                        />
                        <div className="invalid-feedback">
                            Fullname is required.
                        </div>
                    </div>

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
                        Register
                    </button>

                </form>

                <Link to="/login" className="btn btn-link" style={{ color: 'darkgray' }}>
                    I have an Account!
                </Link>

            </div>
        </div>
    );
};
export { RegisterPage };