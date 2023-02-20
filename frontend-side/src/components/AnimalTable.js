import React, {useEffect, useState} from 'react'
import axios from 'axios';
import MaterialReactTable from 'material-react-table';
import AnimalEntry from "./AnimalEntry";

const AnimalTable = () => {
    const [animals, setAnimals] = useState([]);
    const [update,setUpdate] = useState("");

    useEffect(() => {
        getAllAnimals();
    }, [])

    useEffect(() => {
        getAllAnimals();
    }, [update])


    const getAllAnimals = () => {
        axios.get("http://localhost:8080/animals").then((result) => setAnimals(result.data)).catch((e) => console.error(e));
    }

    const columns = [
        {
            accessorKey: 'animal.id', //access nested data with dot notation
            header: 'Number',
        },
        {
            accessorKey: 'animal.name',
            header: 'Name',
        },
        {
            accessorKey: 'animal.animalClass', //normal accessorKey
            header: 'Class',
        },
        {
            accessorKey: 'animal.type',
            header: 'Type',
        },
        {
            accessorKey: 'storage',
            header: 'Storage Location',
        },
    ];

    return (<>
            <AnimalEntry stateUpdate={setUpdate}/>
            <MaterialReactTable columns={columns} data={animals}
                                enableColumnActions={false}
                                enableColumnFilters={false}
                                enablePagination={true}
                                enableSorting={false}
                                enableBottomToolbar={true}
                                enableTopToolbar={false}
                                muiTableBodyRowProps={{hover: false}}/>
        </>
    )
}
export default AnimalTable;