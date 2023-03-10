import React, { useCallback, useEffect, useState } from "react";
import Map from "../../components/Map";
import "./styles.css";
import logo from "./logo.png";

function Dashboard() {

  const urlDelivaryMan = "http://localhost:8080/v1/entrega";
  const [userData, setUserData] = useState({});

  useEffect(() => {
    getDeliveryWithFetch();
  }, []);

  const getDeliveryWithFetch = async () => {};
  return (
    <div className="container">
      <div id="navbar">
        <img src={logo} className="logo" alt="ícone da empresa." />
        <span id="name-app">Rock 'N' Code Delivery</span>
      </div>
      <h1 className="slogan">O melhor serviço de entregas!</h1>
      <div id="main">
        <div className="maincards">
          <div id="card-entregas" className="cards">
            <p>Entregas disponíveis</p>
            <hr />
            <table>
              <tr>
                <th>ID</th>
                <th>Endereço</th>
                <th>Valor</th>
                <th>Status</th>
              </tr>
              <tr>
                <td>{userData.id}</td>
                <td>{userData.enderecoDestino}</td>
                <td>{userData.valor}</td>
                <td>{userData.status}</td>
              </tr>
              <tr></tr>
            </table>
          </div>
          <div id="card-entregadores" className="cards">
            <p>Entregadores disponíveis</p>
            <hr />
            <table>
              <tr>
                <th>ID</th>
                <th>Nome</th>
                <th>Placa</th>
              </tr>
              <tr>
                <td>01</td>
                <td>Jaciba</td>
                <td>4.1</td>
              </tr>
            </table>
          </div>
        </div>

        <div className="maincards">
          <div id="formacao-entrega" className="cards">
            <p>Formação de Entrega</p>
            <hr />
            <table>
              <tr>
                <th>Entregador selecionado</th>
                <th>Entregas selecionadas</th>
                <th>Total de entregas</th>
                <th>Tempo estimado</th>
              </tr>
              <tr>
                <td>Luiz Gomes</td>
                <td>03</td>
                <td>30</td>
                <td>10 minutos</td>
              </tr>
            </table>
          </div>
          <div id="entregadores-em-rota" className="cards">
            <p>Entregadores em Rota</p>
            <hr />
            <div id="mapa">
              <Map />
            </div>
          </div>
        </div>
      </div>
      <div id="footer">
        <span>Criado em 2023.</span>
      </div>
    </div>
  );
}

export default Dashboard;
