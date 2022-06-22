import * as React from "react";
import axios from "axios";
import DateUtils from "../utils/DateUtils";
import Env from "../utils/Env";

class Light extends React.Component {
    constructor(props) {
        super(props);
        this.state = {type: "LIGHT_OFF", createdAt: null};
        this.lightOff = this.lightOff.bind(this);
        this.lightOn = this.lightOn.bind(this);
    }

    componentDidMount() {
        this.loadState();
    }

    loadState() {
        console.log("loadState")

        axios.get(Env.apiHost + "/api/action/status/light")
            .then(resp => {
                console.log(resp.data);
                this.setState(prevState => (resp.data));
            })
    }

    lightOff() {
        console.log("lightOff")
        axios.post(Env.apiHost + "/api/action/make?type=LIGHT_OFF")
            .then(resp => {
                console.log(resp.data);
                this.setState(prevState => (resp.data));
            })
    }

    lightOn() {
        console.log("lightOn")
        axios.post(Env.apiHost + "/api/action/make?type=LIGHT_ON")
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
                    <button onClick={this.lightOff}>lightOff</button>
                    <button onClick={this.lightOn}>lightOn</button>
                </div>
                <div>state.type = {this.state.type}</div>
                {this.state.createdAt !== null ?
                    <div>last = {this.dateDiff()}</div> : ""}

            </div>
        )
    }

}

export default Light;