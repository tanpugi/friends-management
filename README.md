Sample API usage...
Hosted on https://quiet-bayou-14854.herokuapp.com

For creating a friend connection...
POST https://quiet-bayou-14854.herokuapp.com/friend
Request: { "friends": ["andy@example.com", "john@example.com"] }
Request: { "friends": ["andy@example.com", "xxx@example.com"] }
Request: { "friends": ["john@example.com", "xxx@example.com"] }

For retrieving all friend list...
GET  https://quiet-bayou-14854.herokuapp.com/friend/list
Request: { "email":  "john@example.com" }

For retrieving all common friend list...
GET  https://quiet-bayou-14854.herokuapp.com/friend/listcommon
Request: { "friends": ["andy@example.com", "john@example.com"] }

For subscribing to an email...
POST  https://quiet-bayou-14854.herokuapp.com/friend/follow
Request: { "requestor": "lisa@example.com", "target": "andy@example.com" }

For unsubscribing to an email...
DELETE https://quiet-bayou-14854.herokuapp.com/friend/follow
Request: { "requestor": "lisa@example.com", "target": "andy@example.com" }

For creating an update...
POST https://quiet-bayou-14854.herokuapp.com/friend/update
Request: { "sender": "andy@example.com", "text": "Hello World! kate@example.com" }