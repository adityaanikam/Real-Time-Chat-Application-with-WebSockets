# Real-Time Chat Application with WebSockets

## Overview
This project is a **Real-Time Chat Application** built using WebSockets to enable instant messaging between users. It showcases the implementation of full-duplex communication between the client and server, allowing seamless interaction in real-time.

## Features
- **Instant Messaging**: Real-time exchange of messages without delays
- **Message History**: Persistent storage of chat logs using SQLite database
- **Auto-reconnection**: Client automatically reconnects if connection is lost
- **Modern UI**: Beautiful and responsive user interface
- **Cross-platform**: Works on desktop and mobile devices
- **Production Ready**: Optimized for deployment on cloud platforms

## Technologies Used

### Backend:
- **Java 17**: Core programming language
- **Spring Boot 3.3.5**: Framework for building the backend services
- **Spring WebSocket**: Enables real-time communication
- **Spring Data JPA**: For database operations
- **SQLite**: Lightweight database for storing messages
- **Jackson**: JSON processing

### Frontend:
- **HTML5/CSS3/JavaScript**: For building the user interface
- **WebSocket API**: Client-side real-time communication
- **Modern CSS**: Gradients, animations, and responsive design

### Deployment:
- **Backend**: Render, Railway, or Heroku
- **Frontend**: Netlify
- **Database**: SQLite (file-based, included in JAR)

## Project Structure

```
Real-Time-Chat-Application-with-WebSockets/
├── src/main/java/com/aditya/
│   ├── RealTimeChatApplicationWithWebSocketsApplication.java
│   ├── WebSocketConfig.java
│   ├── ChatHandler.java
│   ├── Message.java
│   ├── MessageRepository.java
│   └── ChatMessage.java
├── src/main/resources/
│   ├── application.properties
│   └── static/index.html
├── frontend/
│   └── index.html (for Netlify deployment)
├── pom.xml
├── netlify.toml
└── README.md
```

## Local Development Setup

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- Git

### Steps
1. **Clone the repository:**
   ```bash
   git clone https://github.com/adityaanikam/Real-Time-Chat-Application-with-WebSockets.git
   cd Real-Time-Chat-Application-with-WebSockets
   ```

2. **Build and run the backend:**
   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

3. **Access the application:**
   - Open your browser and go to `http://localhost:8080`
   - The chat interface will be available immediately
   - Open multiple browser tabs to test real-time messaging

## Production Deployment

### Backend Deployment (Choose one platform)

#### Option 1: Deploy to Render
1. **Fork this repository** to your GitHub account

2. **Sign up for Render** at [render.com](https://render.com)

3. **Create a new Web Service:**
   - Connect your GitHub repository
   - Choose "Java" as the environment
   - Set the following:
     - **Build Command:** `./mvnw clean install`
     - **Start Command:** `java -jar target/*.jar`
     - **Environment Variables:**
       - `SPRING_PROFILES_ACTIVE=prod`
       - `PORT=8080`

4. **Deploy and get your backend URL** (e.g., `https://your-app-name.onrender.com`)

#### Option 2: Deploy to Railway
1. **Sign up for Railway** at [railway.app](https://railway.app)

2. **Deploy from GitHub:**
   - Connect your repository
   - Railway will auto-detect it's a Java project
   - Set environment variables:
     - `SPRING_PROFILES_ACTIVE=prod`

3. **Get your deployment URL**

### Frontend Deployment to Netlify

1. **Update the backend URL:**
   - Open `frontend/index.html`
   - Replace `YOUR_BACKEND_URL_HERE` with your backend WebSocket URL
   - Example: `const BACKEND_URL = 'wss://your-backend.onrender.com';`

2. **Deploy to Netlify:**
   
   **Option A: Drag and Drop**
   - Go to [netlify.com](https://netlify.com)
   - Drag the `frontend` folder to the deploy area
   
   **Option B: Git Integration**
   - Connect your GitHub repository
   - Set build settings:
     - **Build command:** `mkdir -p frontend && cp src/main/resources/static/index.html frontend/`
     - **Publish directory:** `frontend`
   
   **Option C: Netlify CLI**
   ```bash
   npm install -g netlify-cli
   netlify login
   cd frontend
   netlify deploy --prod
   ```

3. **Configure Custom Domain (Optional):**
   - Go to Netlify dashboard → Domain management
   - Add your custom domain

### Environment Configuration

#### Backend Environment Variables
```properties
SPRING_PROFILES_ACTIVE=prod
PORT=8080
SPRING_DATASOURCE_URL=jdbc:sqlite:./chat.db
```

#### Frontend Configuration
Update the `BACKEND_URL` in `frontend/index.html`:
```javascript
const BACKEND_URL = 'wss://your-backend-domain.com';
```

## Database

The application uses **SQLite** as the database, which is perfect for production deployment because:
- **File-based**: No separate database server needed
- **Lightweight**: Minimal resource usage
- **Persistent**: Data survives application restarts
- **Zero-configuration**: Works out of the box

The database file (`chat.db`) is automatically created when the application starts and persists all chat messages.

## API Endpoints

### WebSocket Endpoint
- **URL:** `/chat`
- **Protocol:** WebSocket

### Message Types

#### Client to Server:
```json
{
  "type": "chat",
  "text": "Hello, world!",
  "timestamp": "2024-01-01T12:00:00.000Z",
  "clientId": "unique-client-id"
}

{
  "type": "getHistory"
}
```

#### Server to Client:
```json
{
  "type": "chat",
  "text": "Hello, world!",
  "timestamp": "2024-01-01T12:00:00.000Z",
  "clientId": "unique-client-id"
}

{
  "type": "history",
  "messages": [...]
}
```

## Development Commands

```bash
# Run locally
./mvnw spring-boot:run

# Build JAR
./mvnw clean package

# Run tests
./mvnw test

# Clean build
./mvnw clean

# Skip tests during build
./mvnw clean package -DskipTests
```

## Troubleshooting

### Common Issues

1. **WebSocket Connection Failed**
   - Check if backend URL is correct in frontend
   - Ensure CORS is properly configured
   - Verify WebSocket protocol (ws vs wss)

2. **Database Issues**
   - SQLite database is automatically created
   - Check file permissions in deployment environment
   - Verify SQLite JDBC driver is included

3. **Build Failures**
   - Ensure Java 17 is being used
   - Check Maven wrapper permissions: `chmod +x mvnw`
   - Clear Maven cache: `./mvnw dependency:purge-local-repository`

### Deployment Checklist

**Backend:**
- [ ] Repository connected to deployment platform
- [ ] Build and start commands configured
- [ ] Environment variables set
- [ ] Health check endpoint accessible
- [ ] WebSocket endpoint working

**Frontend:**
- [ ] Backend URL updated in frontend code
- [ ] CORS properly configured on backend
- [ ] Netlify build settings configured
- [ ] Custom domain configured (if needed)

## Contributing
Contributions are welcome! To contribute:
1. Fork the repository
2. Create a new branch for your feature or bugfix
3. Commit your changes and push the branch
4. Create a pull request explaining your changes

## License
This project is licensed under the [MIT License](LICENSE).

## Contact
For questions or support, feel free to contact:
- **Name**: Aditya Nikam
- **Email**: [adityanikam9502@gmail.com](mailto:adityanikam9502@gmail.com)

## Acknowledgements
- Thanks to the Spring Boot community for excellent documentation
- Inspired by modern chat applications like Discord and Slack

