const fs = require('fs').promises;

fs.readdir('./')
  .then((result) => console.log(result))
  .catch((err) => console.error(err));
