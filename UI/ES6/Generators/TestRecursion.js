class Comment{
    content;
    children;

    constructor(content, children){
        this.content = content;
        this.children = children;
    }

    *[Symbol.iterator](){
        yield this.content;
        for(let child of this.children){
            yield* child;
        }
    }
    
}

children = [
    new Comment('Good Comment', []),
    new Comment('bad Comment', []),
    new Comment('no Comment', [])
   
]

const comment = new Comment('Good Post', children);

let commentArr = [];
for(let value of comment){
    commentArr.push(value);
}

console.log(commentArr);