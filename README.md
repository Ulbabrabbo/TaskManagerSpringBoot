Task Manager Spring Boot

REQUIREMENTS:
- Java 17+

EXECUTION:
- Open the terminal in the root directory of the project.
- Run the application using one of the following commands:
  - "mvn spring-boot:run" (with Maven installed).
  - ".\mvnw spring-boot:run" (using the integrated Maven Wrapper).

TEST with Bruno:
To test the application using [Bruno](https://docs.usebruno.com/), follow these steps after starting the application as described above:

- Create a new collection in Bruno ([Quick Start Guide](https://docs.usebruno.com/introduction/quick-start)).
- Create the following HTTP requests:

1. Get all tasks: Returns the list of all available tasks.
- Type: HTTP
- Method: GET
- URL: "http://localhost:8080/api/tasks"

2. Get tasks filtered by status
- Type: HTTP
- Method: GET
- URL: "http://localhost:8080/api/tasks?status={STATUS}" (Replace "{STATUS}" with a valid status (TODO, DONE or IN_PROGRESS)
Example: "http://localhost:8080/api/tasks?status=TODO"

3. Get task by ID
- Type: HTTP
- Method: GET
- URL: "http://localhost:8080/api/tasks/{id}" (Replace "{id}" with the ID of the task you want to retrieve)
Example: "http://localhost:8080/api/tasks/1"

4. Create a new task
- Type: HTTP
- Method: POST
- URL: "http://localhost:8080/api/tasks"
- Body: JSON
Example request body (JSON):
{
    "title": "title_text",
    "description": "description_text",
    "status": "TODO"
}
The request body must contain the fields required by the "Task" (Title and Status)
Returns the newly created task with HTTP status "201 CREATED".

5. Update an existing task
- Type: HTTP
- Method: PUT
- URL: "http://localhost:8080/api/tasks/{id}"   (Replace "{id}" with the ID of the task you want to update)
- Body: JSON
Example: "http://localhost:8080/api/tasks/1"
Example request body (JSON):
{
    "title": "Complete Spring Boot project",
    "description": "Task updated successfully",
    "status": "DONE"
}

6. Delete a task
- Type: HTTP
- Method: DELETE
- URL: "http://localhost:8080/api/tasks/{id}"   (Replace "{id}" with the ID of the task you want to delete)
Example: "http://localhost:8080/api/tasks/1"
Returns HTTP status "204 NO CONTENT" if the operation is successful.

Once the requests have been created, you can execute them individually by clicking the "Send" button.
