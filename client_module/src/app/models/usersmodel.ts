export class usermodel{
    public id :string;
    public firstName :string;
    public lastName: string;
    public email:string;
    public phoneNumber:string;
    public address:string;
    public role:number;
    public bNumber:string;
    public status:number;
    public username:string;
    public password:string;
    constructor(){
        this.id = '';
        this.firstName = '';
        this.lastName = '';
        this.email = '';
        this.phoneNumber = '';
        this.address = '';
        this.role = 0;
        this.bNumber = '';
        this.username = '';
        this.password = '';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}