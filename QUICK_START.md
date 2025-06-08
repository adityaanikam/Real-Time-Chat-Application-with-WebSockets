# 🚀 Quick Start Guide

## Local Testing (Choose One)

### Option 1: Docker (Recommended)
```bash
# 1. Start Docker Desktop
# 2. Run the app
.\start-docker.bat
# 3. Open http://localhost:8080
```

### Option 2: Maven (Requires Java 17+)
```bash
# 1. Run the app
.\start-local.bat
# 2. Open http://localhost:8080
```

## Production Deployment

### 1. Backend (Render)
1. Push code to GitHub
2. Go to [render.com](https://render.com) → New Web Service
3. Connect GitHub repo
4. Runtime: **Docker**
5. Set environment variables:
   - `SPRING_PROFILES_ACTIVE=prod`
   - `PORT=8080`
6. Deploy & get URL

### 2. Frontend (Netlify)
1. Edit `frontend/index.html` → Update backend URL
2. Go to [netlify.com](https://netlify.com)
3. Drag & drop `frontend` folder
4. Done!

## 📁 Project Structure
```
├── src/                    # Java backend code
├── frontend/               # HTML frontend for Netlify
├── Dockerfile             # Docker configuration
├── docker-compose.yml     # Local development
├── start-local.bat        # Maven startup
├── start-docker.bat       # Docker startup
└── DEPLOYMENT_GUIDE.md    # Complete instructions
```

## ✅ Features Working
- ✅ Real-time messaging
- ✅ Message persistence (SQLite)
- ✅ Auto-reconnection
- ✅ Mobile responsive
- ✅ Docker ready
- ✅ Production optimized

**For detailed instructions, see [DEPLOYMENT_GUIDE.md](DEPLOYMENT_GUIDE.md)** 