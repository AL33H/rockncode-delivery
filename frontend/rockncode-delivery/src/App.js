import React from "react";
import Map from "./components/Map";

function App() {
  return (
    <div className="container">
      <div id="navbar">
        <img className="logo" alt="ícone da empresa." />
        <span>Rock 'N' Code Delivery</span>
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
                <th>Descrição</th>
                <th>Endereço</th>
                <th>Km</th>
                <th>Valor</th>
              </tr>
              <tr>
                <td>01</td>
                <td>Entrega 01</td>
                <td>Rua 01</td>
                <td>2,5km</td>
                <td>2,50</td>
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
              <th>Entregador selecionado</th>
              <th>Entregas selecionadas</th>
              <th>Total de entregas</th>
              <th>Tempo estimado</th>
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

export default App;
