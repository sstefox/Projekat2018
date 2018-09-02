export class review{
    public id:number;
    public rating:number;
    public comment:string;
    public entryDate:string;
    public status:number;
    public user:string;
    constructor(){
        this.id = 0;
        this.rating=0;
        this.comment='';
        this.entryDate='';
        this.status=0;
        this.user='';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}