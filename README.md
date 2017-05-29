<h3>Sample API usage...</h3><br />
<h4>Hosted on https://quiet-bayou-14854.herokuapp.com</h4> <p />

For creating a friend connection... <br />
POST https://quiet-bayou-14854.herokuapp.com/friend <br />
Request: { "friends": ["andy@example.com", "john@example.com"] } <br />
Request: { "friends": ["andy@example.com", "xxx@example.com"] } <br />
Request: { "friends": ["john@example.com", "xxx@example.com"] } <p />

For retrieving all friend list...  <br />
GET  https://quiet-bayou-14854.herokuapp.com/friend/list <br />
Request: { "email":  "john@example.com" } <p />

For retrieving all common friend list... <br />
GET  https://quiet-bayou-14854.herokuapp.com/friend/listcommon <br />
Request: { "friends": ["andy@example.com", "john@example.com"] } <p />

For subscribing to an email... <br />
POST  https://quiet-bayou-14854.herokuapp.com/friend/follow <br />
Request: { "requestor": "lisa@example.com", "target": "andy@example.com" } <p />

For unsubscribing to an email... <br />
DELETE https://quiet-bayou-14854.herokuapp.com/friend/follow <br />
Request: { "requestor": "lisa@example.com", "target": "andy@example.com" } <p />

For creating an update... <br />
POST https://quiet-bayou-14854.herokuapp.com/friend/update <br />
Request: { "sender": "andy@example.com", "text": "Hello World! kate@example.com" } <p />
