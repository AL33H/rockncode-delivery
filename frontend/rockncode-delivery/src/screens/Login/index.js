import React, { useRef, useState } from "react";
import "./login.css";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [email] = useState("");
  const [password, setPassword] = useState("");
  const emailRef = useRef();

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(email, password);
  };

  const navigate = useNavigate();

  return (
    <div id="container">
      <h1>Olá, operador(a)!</h1>

      <hr />

      <form onSubmit={handleSubmit}>
        <label>
          <p>E-mail:</p>
          <input
            placeholder="Insira seu e-mail aqui"
            type="email"
            value={email}
            onChange={(event) => (emailRef.current.value = event.target.value)}
          />
        </label>

        <label>
          <p>Senha:</p>

          <input
            type="password"
            placeholder="Insira sua senha aqui"
            value={password}
            onChange={(event) => setPassword(event.target.value)}
          />
        </label>

        <button type="submit" onClick={() => navigate("Dashboard")}>
          Entrar
        </button>
      </form>
    </div>
  );
};

export default Login;
