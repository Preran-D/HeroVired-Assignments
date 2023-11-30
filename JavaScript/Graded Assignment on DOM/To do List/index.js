const taskInput = document.getElementById('taskInput');
const tasksContainer = document.getElementById('tasksContainer');
const completedTasksContainer = document.getElementById('completedTasksContainer');
const totalTaskCount = document.getElementById('totalTaskCount');
const completedTaskCount = document.getElementById('completedTaskCount');


function addTask() {
    const taskText = taskInput.value.trim();

    if (taskText !== '') {
        const taskElement = createTaskElement(taskText);
        tasksContainer.appendChild(taskElement);
        taskInput.value = '';
        updateTaskCount();
    }
}

function createTaskElement(taskText) {
    const taskElement = document.createElement('div');
    taskElement.classList.add('task');

    const checkbox = document.createElement('input');
    checkbox.type = 'checkbox';
    checkbox.classList.add('round-checkbox');
    checkbox.addEventListener('change', function () {
        handleTaskCompletion(taskElement, checkbox.checked);
    });

    const taskTextElement = document.createElement('div');
    taskTextElement.textContent = taskText;
    taskTextElement.classList.add('task-text');

    const deleteButton = document.createElement('button');
    deleteButton.textContent = 'Delete';
    deleteButton.classList.add('delete');
    deleteButton.addEventListener('click', function () {
        tasksContainer.removeChild(taskElement);
        updateTaskCount();
    });

    taskElement.appendChild(checkbox);
    taskElement.appendChild(taskTextElement);
    taskElement.appendChild(deleteButton);

    return taskElement;
}


function handleTaskCompletion(taskElement, isCompleted) {
    const deleteButton = taskElement.querySelector('.delete');

    if (isCompleted) {
        taskElement.classList.add('completed-task');
        completedTasksContainer.appendChild(taskElement);

        deleteButton.addEventListener('click', function () {
            completedTasksContainer.removeChild(taskElement);
            updateTaskCount();
        });
    } else {
        taskElement.classList.remove('completed-task');
        tasksContainer.appendChild(taskElement);

        deleteButton.addEventListener('click', function () {
            tasksContainer.removeChild(taskElement);
            updateTaskCount();
        });
    }

    updateTaskCount();
}


function updateTaskCount() {
    const totalTasks = tasksContainer.childElementCount;
    const completedTasks = completedTasksContainer.childElementCount;

    totalTaskCount.textContent = `Total Tasks: ${totalTasks}`;
    completedTaskCount.textContent = `Completed: ${completedTasks}`;
}




