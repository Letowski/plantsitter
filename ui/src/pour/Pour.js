import * as React from "react";
import axios from "axios";
import DateUtils from "../utils/DateUtils";
import Env from "../utils/Env";

class Pour extends React.Component {
    constructor(props) {
        super(props);
        this.state = {type: "POUR_WATER", createdAt: null};
        this.pourWater = this.pourWater.bind(this);
    }

    componentDidMount() {
        this.loadState();
    }

    loadState() {
        console.log("loadState")

        axios.get(Env.apiHost + "/api/action/status/pour")
            .then(resp => {
                console.log(resp.data);
                this.setState(prevState => (resp.data));
            })
    }

    pourWater() {
        console.log("pourWater")
        axios.post(Env.apiHost + "/api/action/make?type=POUR_WATER")
            .then(resp => {
                console.log(resp.data);
                this.setState(prevState => (resp.data));
            })
    }

    dateDiff() {
        let createdAtDate = DateUtils.parseDate(this.state.createdAt);
        let nowDate = new Date();
        return DateUtils.dateDiffText(createdAtDate, nowDate);
    }

    render() {
        return (

            <div>
                <div>
                    <button onClick={this.pourWater}>pourWater</button>
                </div>
                {this.state.createdAt !== null ?
                    <div>last = {this.dateDiff()}</div> : ""}

            </div>
        )
    }

}

export default Pour;