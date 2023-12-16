import { apiClient } from "./ApiClient";

export const retriveAllTodos = () => apiClient.get('/todos');

export const getTodoById = (id) => apiClient.get(`/todos/${id}`);
export const saveTodo = (todo) => apiClient.post('/todos',todo);
export const deleteTodo = (id) => apiClient.delete(`/todos/${id}`);
export const updateTodo = (todo) => apiClient.put('/todos',todo);  
