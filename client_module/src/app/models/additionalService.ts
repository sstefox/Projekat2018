export class additionalService{
    public id :string;
    public serviceName :string;
    constructor(){
        this.id = '';
        this.serviceName = '';
    }
    fromJSON(json) {
        for (var propName in json)
            this[propName] = json[propName];
        return this;
    }
}