# Sistema de Gestão Hoteleira

Sistema desktop desenvolvido em Java e JavaFX para controle de quartos de hotel, status de ocupação e previsão de diárias.

## Grupo

| Nome | Prontuário |
| :--- | :--- |
| **Larissa da Silva Pereira** | `BV3060152` |
| **Maria Clara Paes de Mello Jaria** | `BV3071529` |

---

## Requisitos Funcionais

* **RF #01 - Cadastro de Quartos:** Permite cadastrar novos quartos informando número, categoria e valor da diária, validando os dados numéricos inseridos.
* **RF #02 - Registro de Check-in / Ocupação:** Vincula um hóspede a um quarto vago, registrando a data de entrada e o prazo de permanência (em dias).
* **RF #03 - Validação de Reserva/Ocupação:** Impede novos check-ins em quartos já ocupados e exibe um alerta de bloqueio ao usuário.
* **RF #04 - Previsão de Desocupação:** Calcula e exibe dinamicamente a contagem regressiva de quantos dias faltam para o quarto ficar disponível novamente.
* **RF #05 - Liberação / Check-out:** Encerra a estadia, calcula o valor total a pagar com base nas diárias e restaura o status do quarto para `VAGO`.
* **RF #06 - Dashboard e Visualização:** Painel principal interativo em JavaFX que renderiza todos os quartos cadastrados em *cards* dinâmicos identificados por cor (`Verde` = Vago, `Vermelho` = Ocupado).

---

## Tecnologias Utilizadas

* Linguagem: Java
* Interface Gráfica: JavaFX + FXML + CSS
* Gerenciador de Dependências: Maven

## Arquitetura e Estrutura de Pastas

```text
hotel-system/
├── src/
│   └── main/
│       ├── java/
│       │   ├── module-info.java
│       │   └── com/
│       │       └── hotel/
│       │           ├── MainApp.java                      # Classe principal (Inicia o JavaFX)
│       │           │
│       │           ├── model/
│       │           │   ├── Quarto.java                   # Atributos do quarto e vínculo com hóspede
│       │           │   ├── Hospede.java                  # Dados do hóspede
│       │           │   └── StatusQuarto.java             # Enum (VAGO, OCUPADO)
│       │           │
│       │           ├── repository/
│       │           │   └── QuartoRepository.java         # Lista em memória, dados iniciais e operações
│       │           │
│       │           └── controller/
│       │               ├── DashboardController.java      # Gerencia o painel de cards (RF #03, #04, #05, #06)
│       │               ├── CadastroQuartoController.java # Gerencia a tela de cadastro (RF #01)
│       │               └── CheckInController.java        # Gerencia o modal de check-in (RF #02)
│       │
│       └── resources/
│           └── com/
│               └── hotel/
│                   ├── views/
│                   │   ├── DashboardView.fxml            # Layout da tela principal com os cards
│                   │   ├── CadastroQuartoView.fxml       # Formulário de cadastro de quartos
│                   │   └── CheckInModal.fxml             # Pop-up para entrada de hóspedes
│                   │
│                   └── styles/
│                       └── main.css                      # Estilos visuais
│
├── .gitignore
├── pom.xml
└── README.md
```

## Como executar o projeto:

* Clone este repositório:
* Abra o projeto em sua IDE de preferência (IntelliJ IDEA, Eclipse ou VS Code) como um projeto Maven.
* Aguarde o download das dependências do JavaFX definidas no arquivo pom.xml.
* Execute a classe principal com.hotel.MainApp ou rode via terminal Maven:
```text
mvn clean javafx:run
```