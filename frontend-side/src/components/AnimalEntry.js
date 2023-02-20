import {Autocomplete, Snackbar, TextField} from "@mui/material";
import Button from '@mui/material/Button';
import * as React from 'react';
import {data} from "../data/Data";
import axios from "axios";
import TableCss from "../style/TableStyle.css";

const AnimalEntry = ({stateUpdate}) => {
    const [animalClass, setAnimalClass] = React.useState("");
    const [animalType, setAnimalType] = React.useState("");
    const [selectedAnimalType, setSelectedAnimalType] = React.useState("");
    const [animalName, setAnimalName] = React.useState("");
    const [storage, setStorage] = React.useState("");
    const [openSnackBar, setOpenSnackBar] = React.useState(false);

    React.useEffect(() => {
        setAnimalType(data.type[animalClass]);
    }, [animalClass])

    const handleSubmit = (event) => {
        axios.post("http://localhost:8080/animals", prepareMessage()).then((response) => {
            stateUpdate(true);
            setOpenSnackBar(true);
        }).catch((e) => {
            console.error(e);
        });
    }

    const prepareMessage = () => {
        return {
            "animal": {
                "name": animalName,
                "animalClass": animalClass,
                "type": selectedAnimalType,
            },
            "storage": storage
        };
    }


    return (
            <div>
                <table id="dataEntry">
                    <tbody>
                    <tr>
                        <td>Animal Name</td>
                        <TextField style={{width: 300}} onChange={(e) => {
                            setAnimalName(e.target.value)
                        }}/>
                    </tr>
                    <tr>
                        <td>Class</td>
                        <td><Autocomplete
                            options={data.class}
                            onChange={(event, newValue) => {
                                setAnimalClass(newValue);
                            }}
                            disableClearable
                            style={{width: 300}}
                            renderInput={(params) =>
                                <TextField {...params} variant="outlined"/>}
                        /></td>
                    </tr>
                    <tr>
                        <td>Type</td>
                        <td><Autocomplete
                            disabled={!data.class.includes(animalClass)}
                            options={animalType}
                            onChange={(event, newValue) => {
                                setSelectedAnimalType(newValue);
                            }}
                            disableClearable
                            style={{width: 300}}
                            renderInput={(params) =>
                                <TextField {...params} variant="outlined"/>}
                        /></td>
                    </tr>
                    <tr>
                        <td>Storage Location</td>
                        <td><Autocomplete
                            options={data.storages}
                            style={{width: 300}}
                            onChange={(event, newValue) => {
                                setStorage(newValue);
                            }}
                            renderInput={(params) =>
                                <TextField {...params} variant="outlined"/>}
                        /></td>
                    </tr>
                    <tr>
                        <Button variant="contained" style={{marginBottom: "15%"}} onClick={handleSubmit}>Save</Button>
                    </tr>
                    </tbody>
                </table>
                <Snackbar
                    open={openSnackBar}
                    autoHideDuration={1000}
                    style={{marginBottom:"30%"}}
                    message="Animal Stored Successfully!"
                    sx={{ bottom: { xs: 90, sm: 0 } }}
                    onClose={() => setOpenSnackBar(false)}
                />
            </div>
    )

}

export default AnimalEntry;