// selectors
const todoInputs = document.querySelector(".todo-inputs");
const todoButton = document.querySelector(".todo-button");
const todoList = document.querySelector(".todo-list");
const filterOption = document.querySelector(".filter-todos");

// Event listeners
document.addEventListener("DOMContentLoaded", getTodos);
todoButton.addEventListener("click", addTodos);
todoList.addEventListener("click", deleteCheck);
filterOption.addEventListener("click", filterTodo);

function addTodos(e) {
    e.preventDefault();
    if (!todoInputs.value.length)
        return alert("You haven't provided a proper task name.\nTry Again.");

    // Todo data
    const todoData = {
        text: todoInputs.value,
        completed: false,
    };

    // Save to local storage
    saveLocalTodos(todoData);

    // Todo div
    const todoDiv = document.createElement("div");
    todoDiv.classList.add("todo");

    // New todo
    const newTodo = document.createElement("li");
    newTodo.classList.add("todo-item");
    newTodo.innerText = todoData.text;
    todoDiv.appendChild(newTodo);

    // Checked button
    const completedButton = document.createElement("button");
    completedButton.innerHTML = '<i class="fas fa-check"><i>';
    completedButton.classList.add("complete-btn");
    todoDiv.appendChild(completedButton);

    // Trash button
    const trashButton = document.createElement("button");
    trashButton.innerHTML = '<i class="fas fa-trash"><i>';
    trashButton.classList.add("trash-btn");
    todoDiv.appendChild(trashButton);

    // Append to the list
    todoList.appendChild(todoDiv);

    // Clear input
    todoInputs.value = "";
}

function deleteCheck(e) {
    const item = e.target;

    // Delete todo
    if (item.classList.contains("trash-btn")) {
        const todo = item.parentElement;
        removeLocalTodos(todo);
        todo.remove();
    }

    // Completed button
    if (item.classList.contains("complete-btn")) {
        const todo = item.parentElement;
        todo.classList.toggle("completed");
        updateLocalTodos(todo);
    }
}

function filterTodo(e) {
    const todos = todoList.childNodes;
    todos.forEach(function (todo) {
        switch (e.target.value) {
            case "all":
                todo.style.display = "flex";
                break;
            case "completed":
                if (todo.classList.contains("completed")) {
                    todo.style.display = "flex";
                } else {
                    todo.style.display = "none";
                }
                break;
            case "uncompleted":
                if (!todo.classList.contains("completed")) {
                    todo.style.display = "flex";
                } else {
                    todo.style.display = "none";
                }
                break;
        }
    });
}

function saveLocalTodos(todoData) {
    // Check for existing todos in local storage
    let todos = JSON.parse(localStorage.getItem("todos")) || [];

    // Add the new todo data
    todos.push(todoData);

    // Update local storage
    localStorage.setItem("todos", JSON.stringify(todos));
}

function removeLocalTodos(todo) {
    let todos = JSON.parse(localStorage.getItem("todos")) || [];

    // Find and remove the todo from the local storage
    const todoText = todo.children[0].innerText;
    todos = todos.filter((todoData) => todoData.text !== todoText);

    // Update local storage
    localStorage.setItem("todos", JSON.stringify(todos));
}

function updateLocalTodos(todo) {
    let todos = JSON.parse(localStorage.getItem("todos")) || [];

    // Find and update the completed status in local storage
    const todoText = todo.children[0].innerText;
    todos.forEach((todoData) => {
        if (todoData.text === todoText) {
            todoData.completed = todo.classList.contains("completed");
        }
    });

    // Update local storage
    localStorage.setItem("todos", JSON.stringify(todos));
}

function getTodos() {
    let todos = JSON.parse(localStorage.getItem("todos")) || [];

    todos.forEach(function (todoData) {
        // Todo div
        const todoDiv = document.createElement("div");
        todoDiv.classList.add("todo");

        // Create li
        const newTodo = document.createElement("li");
        newTodo.classList.add("todo-item");
        newTodo.innerText = todoData.text;
        todoDiv.appendChild(newTodo);

        if (todoData.completed) {
            todoDiv.classList.add("completed");
        }

        // Checked button
        const completedButton = document.createElement("button");
        completedButton.innerHTML = '<i class="fas fa-check"><i>';
        completedButton.classList.add("complete-btn");
        todoDiv.appendChild(completedButton);

        // Trash button
        const trashButton = document.createElement("button");
        trashButton.innerHTML = '<i class="fas fa-trash"><i>';
        trashButton.classList.add("trash-btn");
        todoDiv.appendChild(trashButton);

        // Append to the list
        todoList.appendChild(todoDiv);
    });
}