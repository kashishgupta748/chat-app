document.getElementById('sendButton').addEventListener('click', function() {
  var messageInput = document.getElementById('messageInput');
  var messageText = messageInput.value.trim();

  if (messageText) {
    // Create sent message
    var messageDiv = document.createElement('div');
    messageDiv.classList.add('message', 'sent');
    messageDiv.textContent = messageText;

    // Append to the chat box
    document.getElementById('messages').appendChild(messageDiv);

    // Scroll to the bottom of the chat
    document.getElementById('messages').scrollTop = document.getElementById('messages').scrollHeight;

    // Clear the input field
    messageInput.value = '';
  }
});

function addReceivedMessage(messageText) {
  var messageDiv = document.createElement('div');
  messageDiv.classList.add('message', 'received');
  messageDiv.textContent = messageText;

  // Append to the chat box
  document.getElementById('messages').appendChild(messageDiv);

  // Scroll to the bottom of the chat
  document.getElementById('messages').scrollTop = document.getElementById('messages').scrollHeight;
}

// Example: Add a received message after 3 seconds
setTimeout(function() {
  addReceivedMessage("Hey! How are you?");
}, 3000);
