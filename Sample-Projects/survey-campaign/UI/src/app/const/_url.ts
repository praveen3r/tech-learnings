import { environment } from './../../environments/environment';
export const _url = {
    login:environment.server+'app/authentication',
    logout:environment.server+'app/logout',
    register:environment.server+'register',
    addCompaign:environment.server+'campaign',
    getCompaigns:environment.server+'campaigns',
    getCompaign:environment.server+'campaign/',
    removeCampaigns:environment.server+'campaigns/',
    noUser:environment.server+'activeUser',
    userList:environment.server+'users',
    getUserCampaigns:environment.server+'getUserCampaigns/',
    getUserAttendedCampaigns:environment.server+'getUserAttendedCampaigns/',
    addAnswers:environment.server+'answers/'
}
