export class commentmodel{
    public id :string;
    public comment:string;
    public user:string;
    public entryDate:string;
    public status:number;
    public accommodation:string;
    constructor(){
        this.id = '';
        this.comment='';
        this.user='';
        this.entryDate = '';
        this.status=0;
        this.accommodation='';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}