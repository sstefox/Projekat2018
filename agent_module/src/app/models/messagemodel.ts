export class messagemodel {
  public id: string;
  public message: string;
  public user: string;
  public entryDate: string;
  public status: number;
  public accommodation: string;
  public fromname:string;
  public accId:number;
  constructor() {
    this.accId=0;
    this.id = '';
    this.message = '';
    this.user = '';
    this.entryDate = '';
    this.status = 0;
    this.accommodation = '';
    this.fromname = '';
  }
  fromJSON(json) {
    for (var propName in json)
      this[propName] = json[propName];
    return this;
  }
}