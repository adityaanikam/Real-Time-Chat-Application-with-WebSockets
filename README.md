# Real-Time Chat Application with WebSockets

## Overview
This project is a **Real-Time Chat Application** built using WebSockets to enable instant messaging between users. It showcases the implementation of full-duplex communication between the client and server, allowing seamless interaction in real-time.

## Features
- **Instant Messaging**: Real-time exchange of messages without delays.
- **User Authentication**: Secure login and registration functionality.
- **Group Chats**: Ability to create and join group conversations.
- **Private Chats**: One-on-one messaging between users.
- **Typing Indicators**: Notify users when someone is typing.
- **Message History**: Persistent storage of chat logs.

## Technologies Used
### Backend:
- **Java**: Core programming language.
- **Spring Boot**: Framework for building the backend services.
- **WebSocket API**: Enables real-time communication.
- **Database**: MySQL or MongoDB for storing user and chat data.

### Frontend:
- **HTML/CSS/JavaScript**: For building the user interface.
- **React.js** (optional): For a dynamic and interactive UI.

### Tools:
- **IntelliJ IDEA**: Development environment.
- **Postman**: For testing APIs.
- **Docker** (optional): Containerizing the application.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/adityaanikam/Real-Time-Chat-Application-with-WebSockets.git
   cd Real-Time-Chat-Application-with-WebSockets
   ```
2. Set up the backend:
   - Install Java 17+ and Maven.
   - Configure the database connection in `application.properties`.
   - Run the Spring Boot application:
     ```bash
     mvn spring-boot:run
     ```

3. Set up the frontend:
   - Navigate to the frontend directory (if applicable).
   - Install dependencies:
     ```bash
     npm install
     ```
   - Start the development server:
     ```bash
     npm start
     ```

4. Access the application at `http://localhost:3000` (frontend) or `http://localhost:8080` (backend).

## Usage
1. Register a new account or log in with existing credentials.
2. Start a private chat or join a group conversation.
3. Send and receive messages in real time.

## Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch for your feature or bugfix.
   ```bash
   git checkout -b feature-name
   ```
3. Commit your changes and push the branch.
   ```bash
   git commit -m "Add new feature"
   git push origin feature-name
   ```
4. Create a pull request explaining your changes.

## License
This project is licensed under the [MIT License](LICENSE).

## Contact
For questions or support, feel free to contact:
- **Name**: Aditya Nikam
- **Email**: [adityanikam9502@gmail.com](mailto:adityanikam9502@gmail.com)

## Acknowledgements
- Thanks to the open-source community for their invaluable resources.
- Inspired by modern chat applications like Slack and WhatsApp.

