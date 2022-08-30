import { JsonIgnore, JsonInclude, JsonIncludeType, JsonProperty } from "jackson-js";

@JsonInclude({value: JsonIncludeType.NON_NULL})
export class ResponseData<T> {

    @JsonProperty()
    private statusCode:string | null;

    @JsonProperty()
    private statusMsg:string | null;

    @JsonProperty()
    private success:boolean;

    @JsonProperty()
    private data: T | null;

    constructor() {
        this.statusCode = null;
        this.statusMsg = null;
        this.success = true;
        this.data = null;
    }

    @JsonIgnore()
    get _statusCode(): string | null {
        return this.statusCode;
    }

    set _statusCode(statusCode: string | null) {
        this.statusCode=statusCode; 
    }

    @JsonIgnore()
    get _statusMsg(): string | null {
        return this.statusMsg;
    }

    set _statusMsg(statusMsg: string | null) {
        this.statusMsg=statusMsg; 
    }

    @JsonIgnore()
    get _success(): boolean {
        return this.success;
    }

    set _success(success: boolean) {
        this.success=success; 
    }

    @JsonIgnore()
    get _data(): T | null{
        return this.data;
    }

    set _data(data: T | null) {
        this.data=data; 
    }

}