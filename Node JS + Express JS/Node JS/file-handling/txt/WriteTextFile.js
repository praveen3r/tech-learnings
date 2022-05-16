var fs = require('fs')

var logger = fs.createWriteStream('C:/Docs/Test/Dummy.txt', {
  flags: 'a' // 'a' means appending (old data will be preserved)
})

logger.write('some data') // append string to your file
logger.write('\nmore data') // again
logger.write('\nand more') // again