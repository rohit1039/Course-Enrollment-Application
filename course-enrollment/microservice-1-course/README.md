Course Enrollment Application
================================

# Course Service

### Endpoints

#### Save Course

````
POST /api/save/course HTTP/1.1
Host: localhost:3333
Authorization: Basic YWRtaW46UGEkJHdvcmQ=
Content-Type: application/json
Content-Length: 77

{
"title":"test",
"subtitle":"test-subtitle",
"price":25
}
````

#### Get Courses

````
GET /api/get/allcourses HTTP/1.1
Host: localhost:3333
Authorization: Basic YWRtaW46UGEkJHdvcmQ=
````

#### Delete Course

````
DELETE /api/delete/course/7 HTTP/1.1
Host: localhost:3333
Authorization: Basic YWRtaW46UGEkJHdvcmQ=
````
