<script>
export default {
  data() {
    return {
      name: 'Tom',
      status: true,
      tasks: [],
      task: {},
      taskId: '',
      addedtask: {},
    };
  },
  methods: {
    async getTasks() {
      try {
        const responce = await fetch('http://localhost:8081/api/tasks', {
          method: 'GET',
        });
        const data = await responce.json();
        console.log(data);
        this.tasks = data.map((task) => {
          return {
            id: task.id,
            text: task.text,
          };
        });
      } catch (error) {
        console.log('Error fetching tasks.');
      }
    },

    async getTask(id) {
      if (!id) return;

      try {
        const responce = await fetch(
          `http://localhost:8081/api/tasks/one?id=${encodeURIComponent(id)}`,
          {
            method: 'GET',
          }
        );
        const data = await responce.json();
        this.task = {
          id: data.id,
          text: data.text,
        };
        if (!this.tasks.find((task) => task.id === this.task.id)) {
          this.tasks.push(this.task);
        }
      } catch (error) {
        console.log('Error fetching tasks.', error);
      }
      this.taskId = '';
    },

    async addTask() {
      try {
        const responce = await fetch(`http://localhost:8081/api/tasks`, {
          method: 'POST',
          body: JSON.stringify({
            text: 'New Task',
          }),
        });
        console.log(responce);
        // const data = await responce.json();
        // this.task = {
        //   id: data.id,
        //   text: data.text,
        // };
        // if (!this.tasks.find((task) => task.id === this.task.id)) {
        //   this.tasks.push(this.task);
        // }
      } catch (error) {
        console.log('Error fetching tasks.', error);
      }
    },

    async clearTasksList() {
      this.tasks = [];
    },

    async getAllUsers() {
      try {
        const responce = await fetch('http://localhost:8081/api/users', {
          method: 'GET',
        });
        const data = await responce.json();
        console.log(data);
      } catch (error) {
        console.log('Error fetching tasks.');
      }
    },
  },
};
</script>

<template>
  <div
    class="container"
    style="display: flex; gap: 20px; justify-content: space-between"
  >
    <div
      class="column"
      style="flex: 1; padding: 20px; align-content: center; text-align: center"
    >
      <h1>{{ name }}</h1>
      <p v-if="status">User is active.</p>
    </div>
    <div class="column" style="flex: 1; padding: 20px; align-content: center">
      <form @submit.prevent="getTask(taskId)" style="display: grid">
        <label for="taskId">Task ID:</label>
        <input type="number" name="taskId" id="taskId" v-model="taskId" />
        <button type="submit">Get Task</button>
      </form>
      <ul style="display: contents">
        <li v-for="task in tasks">{{ `ID: ${task.id} ${task.text}` }}</li>
      </ul>
      <div
        class="buttons"
        style="display: flex; gap: 5%; justify-content: center"
      >
        <button @click="getTasks">Get tasks</button>
        <button @click="clearTasksList">Clear</button>
        <button @click="addTask">Add Test Task</button>
        <button @click="getAllUsers">All Users</button>
      </div>
    </div>
  </div>
</template>
