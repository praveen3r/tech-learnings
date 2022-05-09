const express = require('express');
const {getUser, saveUser} = require('./User')
const router = express.Router();

router.get("/", getUser);

router.post("/:id", saveUser);

module.exports = router;