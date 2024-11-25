{
    type: 'chat',      // or 'history' or 'getHistory'
    text: 'message',
    timestamp: '2024-11-24T12:00:00.000Z',
    clientId: 'uniqueId'
}
// On your backend
let chatHistory = [];

// Store messages
chatHistory.push({
    text: message.text,
    type: message.type,
    timestamp: message.timestamp,
    clientId: message.clientId
});
// When receiving a message
if (message.type === 'getHistory') {
    // Send chat history to client
    ws.send(JSON.stringify({
        type: 'history',
        messages: chatHistory
    }));
}