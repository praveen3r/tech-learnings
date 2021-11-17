const team = {
    members: ['Sachin', 'Dravid'],
    teamName: 'India',
    teamSummary: function(){
      return this.members.map(function(member){
            return `${member} is on ${this.teamName}`;
        })
    }
}

console.log(team.teamSummary());

//solution

const team = {
    members: ['Sachin', 'Dravid'],
    teamName: 'India',
    teamSummary: function(){
        return  this.members.map((member) => {
            return `${member} is on ${this.teamName}`;
        })
    }
}

console.log(team.teamSummary());

