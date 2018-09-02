export class accommodationType{
    public id :string;
    public typeName :string;
    constructor(){
        this.id = '';
        this.typeName = '';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}