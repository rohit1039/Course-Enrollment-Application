Course Enrollment Application
================================

## Purchase Service Endpoints

#### Save Purchase

````
POST /api/save/purchase HTTP/1.1
Host: localhost:4444
Authorization: Basic cHVyY2hhc2U6UGEkJHdvcmQ=
Content-Type: application/json
Content-Length: 84

{
    "userID": 1,
    "courseID": 1,
    "title": "course-1",
    "price": 9
}
````

#### Get All Purchases of User

````
GET /api/get/purchase/1 HTTP/1.1
Host: localhost:4444
Authorization: Basic cHVyY2hhc2U6UGEkJHdvcmQ=
````
