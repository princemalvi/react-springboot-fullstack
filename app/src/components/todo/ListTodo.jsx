import { useEffect, useState } from "react";
import { deleteTodo, retriveAllTodos } from "../../api/TodoApiService";
import { useNavigate } from "react-router-dom";

const ListTodo = () => {
  const [todos, setTodos] = useState([]);
  const [message, setMessage] = useState(null);

  const navigate = useNavigate();

  useEffect(() => getAllTodos(), []);
  
  const getAllTodos = () => {
    retriveAllTodos()
      .then((res) => {
        setTodos(res.data);
      })
      .catch((err) => console.log(err));
  };

  const updateTodoById = (id) => {
    navigate(`/addtodo/${id}`);
  };

  const addNewTodo = () => {
    navigate(`/addtodo/-1`);
  };
  const deleteTodoById = (id) => {
    deleteTodo(id)
      .then((res) => {
        setMessage(res.data.msg);
        getAllTodos();
      })
      .catch((err) => console.log(err));
  };

  return (
    <div>
      <table className="table table-striped">
        <thead>
          <tr>
            <th scope="col">Title</th>
            <th scope="col">Description</th>
            <th scope="col">Created Date</th>
            <th scope="col">Completed</th>
            <th scope="col"></th>
            <th scope="col"></th>
          </tr>
        </thead>
        <tbody>
          {todos.map((todo) => (
            <tr key={todo.id}>
              <td>{todo.title}</td>
              <td>{todo.description}</td>
              <td>{todo.createdDate}</td>
              <td>{todo.complete ? "Yes" : "No"}</td>
              <td>
                <button
                  className="btn btn-sm btn-secondary"
                  onClick={() => {
                    updateTodoById(todo.id);
                  }}
                >
                  Edit
                </button>
              </td>
              <td>
                <button
                  className="btn btn-sm btn-danger"
                  onClick={() => {
                    deleteTodoById(todo.id);
                  }}
                >
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      <div className="text-success text-center">{message}</div>

      <div className="text-center">
        <button
          className="btn btn-sm btn-success"
          onClick={() => {
            addNewTodo();
          }}
        >
          Add New Todo
        </button>
        
      </div>
    </div>
  );
};

export default ListTodo;
