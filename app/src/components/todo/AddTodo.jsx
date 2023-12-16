import { useEffect, useState } from "react";
import { updateTodo, saveTodo, getTodoById } from "../../api/TodoApiService";
import { useNavigate, useParams } from "react-router-dom";
const AddTodo = () => {
  const [title, setTitle] = useState();

  const [description, setDescription] = useState();

  const { id } = useParams();

  const handleTitle = (e) => {
    setTitle(e.target.value);
  };
  const handleDescription = (e) => {
    setDescription(e.target.value);
  };
  const goBack = () => {
    navigate(`/`);
  };

  const navigate = useNavigate();
  useEffect(() => retriveTodos(), [id]);

  const retriveTodos = () => {
    if (id != -1) {
      getTodoById(id)
        .then((res) => {
          console.log(res.data);
          setTitle(() => res.data.title);
          setDescription(res.data.description);
        })
        .catch((err) => console.log(err));
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (id == -1) {
      const todo = {
        title: title,
        description: description,
        isComplete: false,
        createdDate: new Date().toISOString().split("T")[0],
      };
      saveTodo(todo)
        .then((res) => navigate("/todo"))
        .catch((err) => console.log(err));
    } else {
      const todo = {
        id: id,
        title: title,
        description: description,
        isComplete: false,
        createdDate: new Date().toISOString().split("T")[0],
      };

      updateTodo(todo)
        .then((res) => navigate("/todo"))
        .catch((err) => console.log(err));
    }
    
  };
  return (
    <div className="container-fluid">
      <form>
        <div className="form-group row ">
          <label className="col-sm-2 col-form-label">Title</label>
          <div className="col-sm-4">
            <input
              type="text"
              className="form-control form-control-sm"
              id="title"
              defaultValue={title}
              onChange={handleTitle}
              required
            />
          </div>
        </div>
        <div className="form-group row ">
          <label className="col-sm-2 col-form-label">Description</label>
          <div className="col-sm-4">
            <input
              type="text"
              className="form-control form-control-sm"
              id="description"
              required
              defaultValue={description}
              onChange={handleDescription}
            />
          </div>
        </div>
        <button type="Add Todo" className="btn btn-sm btn-primary" onClick={handleSubmit}>
          {id != -1 ? "Update Todo" : "Add Todo"}
        </button>
        <button
          className="btn btn-sm btn-success ml-2"
          onClick={() => {
            goBack();
          }}
        >
          Go Back
        </button>
      </form>
    </div>
  );
};

export default AddTodo;
