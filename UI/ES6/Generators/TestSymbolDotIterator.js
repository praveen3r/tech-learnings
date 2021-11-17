const testingTeam = {
    lead : 'TestingLead',
    tester: 'TestingTester',
    [Symbol.iterator]: function* () {
        yield this.lead;
        yield this.tester;
    }
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
    yield* team.testingTeam;
}

let teamArr = [];
for(let team of getTeamDetails(developmentTeam)){
    teamArr.push(team)
}

console.log(teamArr);

//refactoring engineering team

const testingTeam = {
    lead : 'TestingLead',
    tester: 'TestingTester',
    [Symbol.iterator]: function* () {
        yield this.lead;
        yield this.tester;
    }
}

const developmentTeam = {
    size: 10,
    team: 'MBP',
    lead: 'Lead',
    engineer: 'Engineer',
    manager: 'Manager',
    testingTeam: testingTeam,
    [Symbol.iterator]: function* () {
        yield this.lead;
    yield this.engineer;
    yield this.manager;
    yield* this.testingTeam;
    }
}

let teamArr = [];
for(let team of developmentTeam){
    teamArr.push(team)
}

console.log(teamArr);

