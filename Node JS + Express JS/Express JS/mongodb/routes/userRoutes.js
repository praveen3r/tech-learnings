const express = require('express');
const {getUser, saveUser, updateUser, deleteUser} = require('../controller/userController')
const router = express.Router();

router.route("/").get(getUser).post(saveUser);

router.route("/:id").put(updateUser).delete(deleteUser);

module.exports = router;