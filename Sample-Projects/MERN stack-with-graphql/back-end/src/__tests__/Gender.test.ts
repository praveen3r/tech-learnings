import { log } from "console";
import { Server } from "http";
import { StatusCodes } from "http-status-codes";
import request from "supertest";
import App from "../app";
import GenderRoute from "../router/GenderRoute";
import GenderService from "../service/GenderService";
import Gender from "../types/Gender";
import { JwtUtils } from "../utils/JwtUtils";

let req: any;
let server: Server;
beforeEach(async () => {
  const app = new App([new GenderRoute()], Number(process.env.PORT));
  server = app.listen();
  req = request(server);
  //authenticate();
});

/*const authenticate = async () => {
  const hash = CryptoJS.AES.encrypt("1", "my-secret-key@123").toString();
  const token = JwtUtils.generateToken({ id: 1 });

  const auth: Auth = {
    username: "1",
    keyword: hash,
  };
  const res = await req
    .post("/api/authenticate")
    .send(auth)

    .set("Authorization", "Bearer " + token);
  console.log(res.body);
  if (res) {
    console.log(res.body);
  }
};*/
//const mockedGenderService = new GenderService();

describe("test Gender GET API", () => {
  it("returns status code 200", async () => {
    //const mockedGenderService = jest.mock("../service/GenderService");

    const mockFetchGenders = jest.spyOn(GenderService.prototype, "getGenders");
    //const mockedGenderService = jest.mocked(GenderService, { shallow: true });
    /*const mockedGenderService = new GenderService() as jest.Mocked<GenderService>;
    mockedGenderService.getGenders.mockImplementationOnce(() =>
      Promise.resolve([{ key: "1", value: "Male123" }])
    );*/
    const gender: Gender[] = [{ key: "1", value: "Male123" }];

    mockFetchGenders.mockReturnValue(
      new Promise<any>((resolve) => resolve(Promise.resolve(gender)))
    );
    const token = JwtUtils.generateToken({ id: 1 });
    const res = await req
      .get("/api/genders")
      .set("Authorization", "Bearer " + token);
    log(res.body);
    expect(res.statusCode).toEqual(StatusCodes.OK);
  });
});

afterEach(async () => {
  jest.restoreAllMocks();
  if (server) {
    server.close();
  }
});
