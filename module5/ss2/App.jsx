import React from "react";
// import heroImg from './assets/hero.png'
// import reactLogo from './assets/react.svg'
// import viteLogo from './assets/vite.svg'
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.js";
import { getAll } from "./service/studentService.js";

function App() {
  const ex1 = React.createElement(
    "select",
    {},
    (React.createElement("option", { value: "hn" }, "hn"),
    React.createElement("option", { value: "hcm" }, "hcm"),
    React.createElement("option", { value: "dn" }, "dn")),
  );

  return (
    <>
      {ex1}

      <h1>Danh sách sinh viên</h1>
      <table className="table table-bordered">
        <thead>
          <tr>
            <th>STT</th>
            <th>id</th>
            <th>name</th>
          </tr>
        </thead>
        <tbody>
          {getAll().map((student, i) => (
            <tr>
              <td>{i}</td>
              <td>{student.id}</td>
              <td>{student.name}</td>
            </tr>
          ))}
        </tbody>
      </table>


      <h1 className="text-white bg-dark">Login form</h1>

      <form action="" className="form form-inline">
        <label htmlFor="">Username</label>
        <input type="text" />
        <br />
        <label htmlFor="">password</label>
        <input type="password" />
      </form>
    </>
  );
}

export default App;
