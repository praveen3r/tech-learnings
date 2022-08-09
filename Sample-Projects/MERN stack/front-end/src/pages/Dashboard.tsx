import React from 'react'
import Header from '../components/Header/Header'
import Home from '../components/home/Home'
import HomeWithGrid from '../components/home/HomeWithGrid'

function Dashboard() {
  return (
    <>
    <Header />
    {/* <Home/> */}
    <HomeWithGrid/>
    </>
  )
}

export default Dashboard