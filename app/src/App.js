import logo from "./logo.svg";
import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import ListTodo from "./components/todo/ListTodo";
import PageNotFound from "./components/404/404";
import Header from "./components/header/Header";
import Footer from "./components/footer/Footer";
import AddTodo from "./components/todo/AddTodo";

function App() {
  return (
    <div>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" Component={ListTodo}></Route>
          <Route path="/todo" Component={ListTodo}></Route>
          <Route path="/addtodo/:id" Component={AddTodo}></Route>
          <Route path="*" Component={PageNotFound}></Route>
        </Routes>
        <Footer />
      </BrowserRouter>
    </div>
  );
}

export default App;
