# Real-Time Chat Application

A modern real-time chat application built with Spring Boot WebSocket and a clean HTML/CSS/JS frontend.

## 🌐 Live Demo

Try the live application at: [https://real-time-chat-application-with.onrender.com](https://real-time-chat-application-with.onrender.com)

## 🚀 Features

- Real-time messaging using WebSocket
- Message persistence with SQLite database
- Auto-reconnection on connection loss
- Mobile-responsive design
- Clean and modern UI
- Docker support for easy deployment

## 🛠️ Local Development

### Prerequisites
- Java 17 or higher
- Maven
- Docker (optional, for containerized development)

### Option 1: Using Docker (Recommended)

1. Start Docker Desktop
2. Run the application:
   ```bash
   .\start-docker.bat
   ```
3. Open [http://localhost:8080](http://localhost:8080)

### Option 2: Using Maven

1. Run the application:
   ```bash
   .\start-local.bat
   ```
2. Open [http://localhost:8080](http://localhost:8080)

## 📁 Project Structure

```
├── src/                    # Java backend code
├── frontend/               # HTML frontend
├── Dockerfile             # Docker configuration
├── docker-compose.yml     # Local development
├── start-local.bat        # Maven startup
└── start-docker.bat       # Docker startup
```

## 🛠️ Built With

- **Backend**: Spring Boot, WebSocket, SQLite
- **Frontend**: HTML5, CSS3, JavaScript
- **Container**: Docker
- **Build Tool**: Maven

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

