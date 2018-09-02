export class messagemodel {
  public id: string;
  public message: string;
  public user: string;
  public entryDate: string;
  public status: number;
  public accommodation: string;
  public date:string;
  public sentBy:string;
  public sentTo:string;
  constructor() {
    this.id = '';
    this.message = '';
    this.user = '';
    this.entryDate = '';
    this.status = 0;
    this.sentBy='';
    this.sentTo='';
    this.date='';
    this.accommodation = '';
  }
  fromJSON(json) {
    for (var propName in json)
      this[propName] = json[propName];
    return this;
  }
}