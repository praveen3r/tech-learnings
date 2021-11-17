function* colors(){
    yield 'red';
    yield 'green';
    yield 'blue';
}

let colorArr = [];
for(let color of colors()){
    colorArr.push(color)
}

console.log(colorArr);

//secondExample - iterating over object properties

const swTeam = {
    size: 10,
    team: 'MBP',
    lead: 'Lead',
    tester: 'Tester',
    manager: 'Manager'

}

function* getTeamDetails(team){
    yield team.lead;
    yield team.tester;
    yield team.manager;
}

let teamArr = [];
for(let team of getTeamDetails(swTeam)){
    teamArr.push(team)
}

console.log(teamArr);

//third example - object within an object

const testingTeam = {
    lead : 'TestingLead',
    tester: 'TestingTester'
}

const developmentTeam = {
    size: 10,
    team: 'MBP',
    lead: 'Lead',
    engineer: 'Engineer',
    manager: 'Manager',
    testingTeam: testingTeam
}

function* getTeamDetails(team){
    yield team.lead;
    yield team.engineer;
    yield team.manager;
    yield* getTestingTeamDetails(team.testingTeam);
}

function* getTestingTeamDetails(team){
    yield team.lead;
    yield team.tester;
   
}

let teamArr = [];
for(let team of getTeamDetails(developmentTeam)){
    teamArr.push(team)
}

console.log(teamArr);