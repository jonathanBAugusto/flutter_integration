import 'dart:ui';
import 'package:flutter/material.dart';
import 'package:flutter_module_teste/app/pages/error_page.dart';
import 'package:flutter_module_teste/app/pages/json_presenter.dart';
import 'package:flutter_module_teste/app/pages/my_home_page.dart';

void main() => runApp(MyApp(
      route: window.defaultRouteName,
    ));

class MyApp extends StatelessWidget {
  const MyApp({Key? key, required this.route}) : super(key: key);

  final String route;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      home: getHome(route),
    );
  }

  Widget getHome(String route) {
    switch (route) {
      case JsonPresenter.routeName:
        return const JsonPresenter();
      case MyHomePage.routeName:
        return const MyHomePage();
      default:
        return const ErrorPage(text: 'Nenhuma feature definida');
    }
  }
}
