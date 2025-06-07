# Deployment Guide - Real-Time Chat Application

This guide will walk you through deploying your Real-Time Chat Application to production using Netlify for the frontend and Render (or Railway) for the backend.

## 🎯 Overview

- **Frontend**: Deployed to Netlify (CDN, static hosting)
- **Backend**: Deployed to Render/Railway (Java Spring Boot)
- **Database**: SQLite (embedded, file-based)
- **WebSocket**: Real-time communication between frontend and backend

## 📋 Prerequisites

Before starting, ensure you have:
- [ ] GitHub account
- [ ] Netlify account ([netlify.com](https://netlify.com))
- [ ] Render account ([render.com](https://render.com)) OR Railway account ([railway.app](https://railway.app))
- [ ] Git installed locally
- [ ] Your code pushed to a GitHub repository

## 🚀 Step-by-Step Deployment

### Phase 1: Backend Deployment

#### Option A: Deploy to Render (Recommended)

1. **Fork/Push to GitHub**
   ```bash
   git add .
   git commit -m "Prepare for production deployment"
   git push origin main
   ```

2. **Sign up for Render**
   - Go to [render.com](https://render.com)
   - Sign up with GitHub account

3. **Create New Web Service**
   - Click "New" → "Web Service"
   - Connect your GitHub repository
   - Select your chat application repository

4. **Configure Build Settings**
   ```
   Name: chat-app-backend (or your preferred name)
   Environment: Java
   Region: Choose closest to your users
   Branch: main
   
   Build Command: ./mvnw clean package -DskipTests
   Start Command: java -jar target/*.jar
   ```

5. **Set Environment Variables**
   ```
   SPRING_PROFILES_ACTIVE=prod
   PORT=8080
   SPRING_DATASOURCE_URL=jdbc:sqlite:./chat.db
   ```

6. **Deploy**
   - Click "Create Web Service"
   - Wait for deployment (usually 5-10 minutes)
   - Note your backend URL: `https://your-app-name.onrender.com`

#### Option B: Deploy to Railway

1. **Sign up for Railway**
   - Go to [railway.app](https://railway.app)
   - Sign up with GitHub

2. **Deploy from GitHub**
   - Click "Deploy from GitHub repo"
   - Select your repository
   - Railway auto-detects Java project

3. **Set Environment Variables**
   ```
   SPRING_PROFILES_ACTIVE=prod
   ```

4. **Get your deployment URL**
   - Railway provides a URL like `https://your-app.railway.app`

### Phase 2: Frontend Deployment

#### Method 1: Direct Netlify Deploy (Easiest)

1. **Update Backend URL**
   - Open `frontend/index.html`
   - Find line: `const BACKEND_URL = 'YOUR_BACKEND_URL_HERE';`
   - Replace with: `const BACKEND_URL = 'wss://your-backend.onrender.com';`
   - Save the file

2. **Deploy to Netlify**
   - Go to [netlify.com](https://netlify.com)
   - Drag and drop the `frontend` folder to the deploy area
   - Your site will be live in seconds!

#### Method 2: Git Integration (Recommended for updates)

1. **Update Backend URL**
   ```javascript
   // In frontend/index.html
   const BACKEND_URL = 'wss://your-backend.onrender.com';
   ```

2. **Push changes to GitHub**
   ```bash
   git add .
   git commit -m "Update backend URL for production"
   git push origin main
   ```

3. **Connect GitHub to Netlify**
   - In Netlify dashboard, click "New site from Git"
   - Choose GitHub and select your repository
   - Configure build settings:
     ```
     Build command: mkdir -p frontend && cp src/main/resources/static/index.html frontend/
     Publish directory: frontend
     ```

4. **Deploy**
   - Click "Deploy site"
   - Your frontend will be live at a URL like `https://amazing-app-name.netlify.app`

## ✅ Post-Deployment Checklist

### Backend Verification
- [ ] Backend URL is accessible
- [ ] Health check: Visit `https://your-backend.onrender.com` (should show Whitelabel Error page - this is normal)
- [ ] WebSocket endpoint: `wss://your-backend.onrender.com/chat` should be accessible

### Frontend Verification
- [ ] Frontend loads correctly
- [ ] Connection status shows "Connected" when backend is running
- [ ] Can send and receive messages
- [ ] Message history loads properly
- [ ] Mobile responsiveness works

### Integration Testing
- [ ] Open frontend in multiple browser tabs
- [ ] Send messages between tabs
- [ ] Verify real-time message delivery
- [ ] Test reconnection (refresh page, should reload history)

## 🔧 Troubleshooting

### Common Issues

#### 1. WebSocket Connection Failed
**Symptoms**: Frontend shows "Connection failed" or "Disconnected"

**Solutions**:
- Verify backend URL in frontend code
- Check if backend is running (visit backend URL)
- Ensure you're using `wss://` for HTTPS sites
- Check browser console for WebSocket errors

#### 2. CORS Issues
**Symptoms**: Connection errors in browser console

**Solutions**:
- Backend already configured with `setAllowedOrigins("*")`
- If issues persist, update WebSocketConfig.java:
```java
registry.addHandler(chatHandler, "/chat")
    .setAllowedOrigins("https://your-frontend-domain.netlify.app");
```

#### 3. Database Issues
**Symptoms**: Messages not persisting

**Solutions**:
- SQLite database auto-creates on first run
- Check backend logs for database errors
- Verify write permissions in deployment environment

#### 4. Build Failures
**Symptoms**: Deployment fails during build

**Solutions**:
- Ensure Java 17 is specified in deployment settings
- Check Maven wrapper permissions
- Verify all dependencies in pom.xml

### Backend Logs
To view backend logs:
- **Render**: Go to your service → "Logs" tab
- **Railway**: Go to your project → "Deployments" → View logs

### Frontend Debugging
- Open browser Developer Tools (F12)
- Check Console tab for JavaScript errors
- Check Network tab for WebSocket connection status

## 🔄 Making Updates

### Updating Backend
1. Make changes to your Java code
2. Commit and push to GitHub
3. Render/Railway will automatically redeploy

### Updating Frontend
1. Update `frontend/index.html`
2. If using drag-and-drop: Re-drag the frontend folder to Netlify
3. If using Git: Commit and push, Netlify will auto-deploy

## 🌐 Custom Domains (Optional)

### Frontend Custom Domain
1. In Netlify dashboard → "Domain management"
2. Add custom domain
3. Update DNS records as instructed

### Backend Custom Domain
1. In Render dashboard → "Settings" → "Custom Domains"
2. Add your domain
3. Update DNS records

## 💡 Production Tips

1. **Monitoring**: Set up uptime monitoring for your backend
2. **SSL**: Both Netlify and Render provide free SSL certificates
3. **Logs**: Regularly check backend logs for errors
4. **Backup**: SQLite database file is automatically persistent
5. **Scaling**: Render and Railway both support auto-scaling

## 🎉 Success!

Your Real-Time Chat Application is now live in production! 

- **Frontend**: Served globally via Netlify's CDN
- **Backend**: Running on cloud infrastructure with auto-scaling
- **Database**: Persistent SQLite storage
- **WebSocket**: Real-time communication enabled

Share your frontend URL with users and enjoy your production chat application!

---

**Need help?** Check the main README.md for additional troubleshooting or contact the developer. 