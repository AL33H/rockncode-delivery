import React, { useState } from "react";
import './login.css';

const Login = () => {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");

    const handleSubmit = (event) => {
    event.preventDefault();
    console.log(email, password);
};

    return (
        <div id="container">

             <h1>Olá, operador(a)!</h1>
            
            <hr/>
            
            <form onSubmit={handleSubmit}>
                <label>
                    <p>E-mail:</p>
                    <input
                        placeholder="Insira seu e-mail aqui"
                        type="email"
                        value={email}
                        onChange={(event) => setEmail(event.target.value)}
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

                <button type="submit">Entrar</button>
            </form>
        </div>
    );
};

export default Login;
