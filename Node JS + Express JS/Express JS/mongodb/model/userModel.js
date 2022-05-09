const mongoose = require('mongoose');

const userSchema = mongoose.Schema({
    id: {
        type: Number,
        required: [true, 'Id is mandatory']
    },
    name: String,
    age: Number,
    date: {
        type: Date,
        default: Date.now
    }
}, {
    timestamps: true
})

module.exports = mongoose.model('user', userSchema);