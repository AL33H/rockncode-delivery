# Rockncode-delivery

## Sobre
O Projeto da aplicação Web Torre de controle permite ao operador realizar a
gestão de entregas da loja/empresa, desde a sua solicitação, análise, indicação do
entregador, roteirização de melhores percursos e entrega efetiva. Alguns
obstáculos foram identificados e para superá-los.

## Objetivo
O Objetivo é promover a melhor experiência de entrega ao consumidor solicitante,
utilizando-se de plataforma intuitiva e simples, sem perder a robustez e segurança
necessária, assim como possibilitar ao operador responsável, gestão ágil e
encorpada de recursos que auxiliarão na tomada de decisão quanto a indicação de
entregador e roteirização.

## Tecnologias
Front: ReactJs
Back: Java, Spring boot
Banco: PostgreSQL(PRODUÇÃO), h2-database(TESTE)

## Recursos Utilizados
O Objetivo é promover a melhor experiência de entrega ao consumidor solicitante,
utilizando-se de plataforma intuitiva e simples, sem perder a robustez e segurança
necessária, assim como possibilitar ao operador responsável, gestão ágil e
encorpada de recursos que auxiliarão na tomada de decisão quanto a indicação de
entregador e roteirização. Foram utilizados os recursos próprios do ambiente de
desenvolvimento como a IDE Vs Code para codifição do projeto, Figma para prototipação,
navegador Google Chrome para sanar dúvidas. Recursos humanos foram: dois dev back end,
um profissional de negócios e um dev front jr.

## Equipe e Contribuições
Formamos um time robusto e qualificado para levantarmos todos os requisitos e
insights necessários à construção deste projeto, tendo como contribuições de toda
a jornada de Back End e Front End....

## Recursos Técnico para upstream Back End.
Coletado e abstraído o objetivo do projeto, iniciamos o levantamento de requisitos e
definição das entidades e atributos que serão armazenados. Uma vez validado e
atendido os requisitos a equipe de Back iniciou as implementações e desenvolvimento
utilizando: 

1- Comando do docker-compose no prompt de comando: 

     docker-compose -f postgres-docker-compose.yml up -d  

2- Executando o Clean e Package no maven 
      
            mvn clean package

3- Selecionando a versão correta do Java

4- Executando o build da aplicação 

5- Iniciar a aplicação do banckend atravez do botão run.






## Recursos Técnico para upstream Front End.
Coletado e abstraído o objetivo do projeto, iniciamos o rascunho e prototipagem das
telas que estarão disponíveis ao operador da torre de controle. Uma vez validado e
atendido os requisitos a equipe de front iniciou as implementações e desenvolvimento
utilizando –  se da  biblioteca React Js usando os comandos npm install e npm start e
para estilização, CSS puro.




## Autores

- [@AL33H](https://github.com/AL33H)
- [@Marcos Oliveira](https://github.com/AL33H)
- [@Sabrina](https://github.com/sdrashen)
- [@Jardel894](https://github.com/Jardel894)


## Documentação da API

Para melhor atender aos testes, foi feito um backup do postman para importação.

Para importar -> File -> Import -> RawText -> Copie e cole o código abaixo.

OBS: Será necessário um novo código de Google Key.

```json
{
	"info": {
		"_postman_id": "288c9c02-8618-42f9-908c-ea0c12f9a2af",
		"name": "hackaton",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "LOCAL",
			"item": [
				{
					"name": "ENTREGA-NEW",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nomeSolicitante\":\"Aleff\",\r\n    \"enderecoOrigem\":\"62960000\",\r\n    \"enderecoDestino\":\"63960000\"\r\n}\r\n",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/v1/entrega",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entrega"
							]
						}
					},
					"response": []
				},
				{
					"name": "ENTREGA-FindById",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/v1/entrega/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entrega",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "ENTREGAFindAll",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/v1/entrega",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entrega"
							]
						}
					},
					"response": []
				},
				{
					"name": "ENTREGA-DeletarByID",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/v1/entrega/2",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entrega",
								"2"
							]
						}
					},
					"response": []
				},
				{
					"name": "ENTREGA-ObterMelhorRota",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/v1/entrega/rotas/?enderecoOrigem=62960000&enderecoFinal=63960000",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entrega",
								"rotas",
								""
							],
							"query": [
								{
									"key": "enderecoOrigem",
									"value": "62960000"
								},
								{
									"key": "enderecoFinal",
									"value": "63960000"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "ENTREGA-VincularEntregadorAEntrega",
					"request": {
						"method": "PUT",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/v1/entrega/vincular/?idEntregador=1&idEntrega=1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entrega",
								"vincular",
								""
							],
							"query": [
								{
									"key": "idEntregador",
									"value": "1"
								},
								{
									"key": "idEntrega",
									"value": "1"
								}
							]
						}
					},
					"response": []
				},
				{
					"name": "ENTREGA-ProximoStatus",
					"request": {
						"method": "PUT",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/v1/entrega/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entrega",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "ENTREGADOR-New",
					"request": {
						"method": "POST",
						"header": [],
						"body": {
							"mode": "raw",
							"raw": "{\r\n    \"nome\":\"Aleff\",\r\n    \"placa\":\"134-344\"\r\n\r\n}",
							"options": {
								"raw": {
									"language": "json"
								}
							}
						},
						"url": {
							"raw": "http://localhost:8080/v1/entregador",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entregador"
							]
						}
					},
					"response": []
				},
				{
					"name": "ENTREGADOR-FINDALL",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/v1/entregador",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entregador"
							]
						}
					},
					"response": []
				},
				{
					"name": "ENTREGADOR-FINDBYID",
					"request": {
						"method": "GET",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/v1/entregador/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entregador",
								"1"
							]
						}
					},
					"response": []
				},
				{
					"name": "ENTREGADOR-DELETEBYID",
					"request": {
						"method": "DELETE",
						"header": [],
						"url": {
							"raw": "http://localhost:8080/v1/entregador/1",
							"protocol": "http",
							"host": [
								"localhost"
							],
							"port": "8080",
							"path": [
								"v1",
								"entregador",
								"1"
							]
						}
					},
					"response": []
				}
			]
		},
		{
			"name": "https://maps.googleapis.com/maps/api/geocode/json?address=Tabuleiro%2do%2norte&key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
			"protocolProfileBehavior": {
				"disabledSystemHeaders": {
					"accept": true
				}
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "default"
					},
					{
						"key": "Accept",
						"value": "application/json",
						"type": "default"
					},
					{
						"key": "key",
						"value": "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
						"type": "default"
					}
				],
				"url": {
					"raw": "https://maps.googleapis.com/maps/api/geocode/json?key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU&address=62960-000",
					"protocol": "https",
					"host": [
						"maps",
						"googleapis",
						"com"
					],
					"path": [
						"maps",
						"api",
						"geocode",
						"json"
					],
					"query": [
						{
							"key": "key",
							"value": "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU"
						},
						{
							"key": "accept",
							"value": "json",
							"disabled": true
						},
						{
							"key": "Conte",
							"value": null,
							"disabled": true
						},
						{
							"key": "address",
							"value": "62960-000"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "https://maps.googleapis.com/maps/api/distancematrix/json?destinations=62960000&origins=63960000&key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
			"protocolProfileBehavior": {
				"disabledSystemHeaders": {
					"accept": true
				}
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "default"
					},
					{
						"key": "Accept",
						"value": "application/json",
						"type": "default"
					},
					{
						"key": "key",
						"value": "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
						"type": "default"
					}
				],
				"url": {
					"raw": "https://maps.googleapis.com/maps/api/distancematrix/json?destinations=62960000&origins=63960000&key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
					"protocol": "https",
					"host": [
						"maps",
						"googleapis",
						"com"
					],
					"path": [
						"maps",
						"api",
						"distancematrix",
						"json"
					],
					"query": [
						{
							"key": "accept",
							"value": "json",
							"disabled": true
						},
						{
							"key": "Conte",
							"value": null,
							"disabled": true
						},
						{
							"key": "destinations",
							"value": "62960000"
						},
						{
							"key": "origins",
							"value": "63960000"
						},
						{
							"key": "key",
							"value": "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "https://maps.googleapis.com/maps/api/directions/json?key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU&origin=itaborai rj&destination=itaguai rj",
			"protocolProfileBehavior": {
				"disabledSystemHeaders": {
					"accept": true
				}
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "default"
					},
					{
						"key": "Accept",
						"value": "application/json",
						"type": "default"
					},
					{
						"key": "key",
						"value": "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
						"type": "default"
					}
				],
				"url": {
					"raw": "https://maps.googleapis.com/maps/api/directions/json?key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU&origin=itaborai rj&destination=itaguai rj",
					"protocol": "https",
					"host": [
						"maps",
						"googleapis",
						"com"
					],
					"path": [
						"maps",
						"api",
						"directions",
						"json"
					],
					"query": [
						{
							"key": "accept",
							"value": "json",
							"disabled": true
						},
						{
							"key": "Conte",
							"value": null,
							"disabled": true
						},
						{
							"key": "key",
							"value": "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU"
						},
						{
							"key": "origin",
							"value": "itaborai rj"
						},
						{
							"key": "destination",
							"value": "itaguai rj"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "https://maps.googleapis.com/maps/api/place/details/json?place_id=ChIJj0-IvKQnz5QRIWEGTh0A8H0&key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
			"protocolProfileBehavior": {
				"disabledSystemHeaders": {
					"accept": true
				}
			},
			"request": {
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"value": "application/json",
						"type": "default"
					},
					{
						"key": "Accept",
						"value": "application/json",
						"type": "default"
					},
					{
						"key": "key",
						"value": "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
						"type": "default"
					}
				],
				"url": {
					"raw": "https://maps.googleapis.com/maps/api/place/details/json?place_id=ChIJj0-IvKQnz5QRIWEGTh0A8H0&key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
					"protocol": "https",
					"host": [
						"maps",
						"googleapis",
						"com"
					],
					"path": [
						"maps",
						"api",
						"place",
						"details",
						"json"
					],
					"query": [
						{
							"key": "accept",
							"value": "json",
							"disabled": true
						},
						{
							"key": "Conte",
							"value": null,
							"disabled": true
						},
						{
							"key": "place_id",
							"value": "ChIJj0-IvKQnz5QRIWEGTh0A8H0"
						},
						{
							"key": "key",
							"value": "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU"
						}
					]
				}
			},
			"response": []
		},
		{
			"name": "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-5.181672%2C-37.8195295&radius=5000&key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
			"request": {
				"method": "GET",
				"header": [],
				"url": {
					"raw": "https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-5.181672%2C-37.8195295&radius=5000&key=AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU",
					"protocol": "https",
					"host": [
						"maps",
						"googleapis",
						"com"
					],
					"path": [
						"maps",
						"api",
						"place",
						"nearbysearch",
						"json"
					],
					"query": [
						{
							"key": "location",
							"value": "-5.181672%2C-37.8195295"
						},
						{
							"key": "radius",
							"value": "5000"
						},
						{
							"key": "key",
							"value": "AIzaSyDaDcRBJBGojQWEaULJuACXfY3HM0TdanU"
						}
					]
				}
			},
			"response": []
		}
	]
}
```


## Referência

- [Google](https://developers.google.com/maps/documentation/places/web-service/search?hl=pt-br)
- [CD2 RETAIL TECH PLAYERS](https://cd2.com.br/)
- [INSTIVO PLAYERS](https://www.linkedin.com/company/instivo/)


## Conclusão

"Queridos colaboradores,

Hoje é um dia muito especial para nossa empresa, pois estamos iniciando mais um hackathon! Este é um momento incrível para colocarmos nossa criatividade e conhecimento em ação, unindo forças para solucionar problemas e criar novas soluções inovadoras.

Lembre-se: o sucesso de um hackathon depende de cada um de nós. Portanto, venha com sua energia, entusiasmo e determinação para fazer a diferença. Não tenha medo de compartilhar suas ideias, mesmo as mais ousadas, pois é a partir delas que surgirão as melhores soluções.

Aproveitem esta oportunidade para aprender e crescer juntos, construindo relacionamentos fortes e colaborativos com colegas de trabalho. Lembrem-se, juntos somos mais fortes e podemos alcançar coisas incríveis.

Vamos lá, mostre sua paixão e dedicação ao trabalho, e vamos fazer deste hackathon um sucesso juntos! Juntos, podemos mudar o mundo.

Boa sorte e divirtam-se!"