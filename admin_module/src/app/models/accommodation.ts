export class accommodation{
    public location :string;
    public description :string;
    public price :number;
    public capacity :number;
    public acctype: string;
    public services:string[];
    public username:string;
    constructor(){
        this.location = '';
        this.description = '';
        this.price = 0;
        this.capacity = 0;
        this.acctype = '';
        this.services = [];
        this.username = ''; 
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}