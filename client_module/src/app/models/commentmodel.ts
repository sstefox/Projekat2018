export class commentmodel{
    public id :string;
    public message:string;
    public username:string;
    public date:string;
    public status:number;
    public accommodation:string;
    constructor(){
        this.id = '';
        this.message='';
        this.username='';
        this.date = '';
        this.status=0;
        this.accommodation='';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}